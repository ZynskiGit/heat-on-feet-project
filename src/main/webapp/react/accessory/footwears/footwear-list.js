import FootwearEditorInline from "./footwear-editor-inline";
import footwearService from "./footwear-service"

const FOOTWEAR_URL = "http://localhost:8080/api/footwears"
const { useState, useEffect } = React;

const FootwearList = () => {
    const [footwears, setFootwears] = useState([])
    const [newFootwear, setNewFootwear] = useState({})
    useEffect(() => {
        findAllFootwears()
    }, [])
    const createFootwear = (footwear) =>
        footwearService.createFootwear(footwear)
            .then(footwear => {
                setNewFootwear({name:''})
                setFootwears(footwears => ([...footwears, footwear]))
            })
    const updateFootwear = (id, newFootwear) =>
        footwearService.updateFootwear(id, newFootwear)
            .then(footwear => setFootwears(footwears => (footwears.map(footwear => footwear.id === id ? newFootwear : footwear))))
    const findAllFootwears = () =>
        footwearService.findAllFootwears()
            .then(footwears => setFootwears(footwears))
    const deleteFootwear = (id) =>
        footwearService.deleteFootwear(id)
            .then(footwears => setfootwears(footwears => footwears.filter(footwear => footwear.id !== id)))
    return(
        <div>
            <h2>Footwears</h2>
            <ul className="list-group">
                <li className="list-group-item">
                    <div className="row">
                        <div className="col">
                            <input placeholder="Footwear Name"
                                   title="Please enter a name for the footwear." className="form-control" value={newFootwear.name}
                                   onChange={(e) => setNewFootwear(newFootwear => ({...newFootwear, name: e.target.value}))}/>
                        </div>
                        <div className="col-3">
                            <i className="fas fa-plus fa-2x float-right" onClick={() => createFootwear(newFootwear)}></i>
                        </div>
                    </div>
                </li>
                {
                    footwears.map(footwear =>
                        <li key={footwear.id} className="list-group-item">
                            <FootwearEditorInline key={footwear._id}
                                                updateFootwear={updateFootwear}
                                                deleteFootwear={deleteFootwear}
                                                footwear={footwear}/>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default FootwearList;