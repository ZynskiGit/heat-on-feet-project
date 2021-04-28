const FOOTWEAR_URL = "http://localhost:8080/api/footwears"

export const createFootwear = (footwear) =>
    fetch(FOOTWEAR_URL, {
        method: 'POST',
        body: JSON.stringify(footwear),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const findAllCourses = () =>
    fetch(FOOTWEAR_URL)
        .then(response => response.json())

export const findFootwearById = (id) =>
    fetch(`${FOOTWEAR_URL}/${id}`)
        .then(response => response.json())

export const updateFootwear = (id, footwear) =>
    fetch(`${FOOTWEAR_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(footwear),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

const deleteFootwear = (id) =>
    fetch(`${FOOTWEAR_URL}/${id}`, {
        method: "DELETE"
    })

export default {
    createFootwear,
    findAllFootwears,
    findFootwearById,
    updateFootwear,
    deleteFootwear
}