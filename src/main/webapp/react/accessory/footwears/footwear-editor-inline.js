const {useState, useEffect } = React;
const {Link} = window.ReactRouterDOM;

const FootwearEditorInline = ({footwear, deleteFootwear, updateFootwear}) => {
    const [footwearCopy, setFootwearCopy] = useState(footwear)
    const [editing, setEditing] = useState(false)
    return(
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={footwearCopy.name}
                            onChange={(e)=>setFootwearCopy(footwearCopy => ({...footwearCopy, name: e.target.value}))}/>
                    </div>
                    <div className="col-1">
                        <Link to={`/footwears/${footwearCopy.id}/brands`}>
                            Brands
                        </Link>
                    </div>
                    <div className="col-2">
                        <Link to={`/footwears/${footwearCopy.id}/colors`}>
                            Colors
                        </Link>
                    </div>
                    <div className="col-3">
                        <Link to={`/footwears/${footwearCopy.id}/materials`}>
                            Materials
                        </Link>
                    </div>
                    <div className="col-4">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateFootwear(footwearCopy.id, footwearCopy)
                           }}></i>
                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deleteFootwear(footwear.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/footwears/${footwearCopy.id}`}>
                            {footwearCopy.name}
                        </Link>
                    </div>
                    <div className="col-1">
                        <Link to={`/footwears/${footwearCopy.id}/brands`}>
                            Brands
                        </Link>
                    </div>
                    <div className="col-2">
                        <Link to={`/footwears/${footwearCopy.id}/colors`}>
                            Colors
                        </Link>
                    </div>
                    <div className="col-3">
                        <Link to={`/footwears/${footwearCopy.id}/materials`}>
                            materials
                        </Link>
                    </div>
                    <div className="col-4">
                        <i className="fas fa-cog fa-2x float-right"
                           onClick={() => setEditing(true)}></i>
                    </div>
                </div>
            }
        </div>
    )
}

export default FootwearEditorInline;