import footwearService, {findFootwearById} from "./footwear-service"

const {useState, useEffect} = React
const {useParams, useHistory} = window.ReactRouterDOM;
const FOOTWEAR_URL = "http://localhost:8080/api/footwears"

const FootwearEditorForm = () => {
    const [footwear, setFootwear] = useState({})
    const {id} = useParams()
    const history = useHistory()
    useEffect(() => {
        findFootwearById(id)
    }, []);
    const findFootwearById = (id) =>
        courseService.findFootwearById(id)
            .then(footwear => setFootwear(footwear))
    const updateFootwear = (id, newFootwear) =>
        footwearService.updateFootwear(id, newFootwear)
            .then(() => history.goBack())
    const deleteFootwear = (id) =>
        footwearService.deleteFootwear(id)
            .then(() => history.goBack())

    return (
        <div>
            <h2>
                Footwear Editor
            </h2>
            <label>Id</label>
            <input
                className="form-control margin-bottom-10px"
                readOnly={true}
                value={footwear.id}/>
            <label>Name</label>
            <input
                className="form-control margin-bottom-10px"
                onChange={(e) => setFootwear(footwear => ({...footwear, name: e.target.value}))}
                value={footwear.name}/>
            <button
                onClick={() => updateFootwear(footwear.id, footwear)}
                className="btn btn-success btn-block">Save</button>
            <button
                onClick={() => {
                    history.goBack()
                }}
                className="btn btn-danger btn-block margin-left-10px">Cancel</button>
            <button
                onClick={() => deleteFootwear(footwear.id)}
                className="btn btn-danger btn-block margin-left-10px">Delete</button>
        </div>
    )
}

export default FootwearEditorForm