const FOOTWEAR_URL = "http://localhost:8080/api/footwears"
const BRAND_URL = "http://localhost:8080/api/brands"

export const createBrandForCourse = (brandId, brand) =>
    fetch(`${FOOTWEAR_URL}/${footwearId}/brands`, {
        method: 'POST',
        body: JSON.stringify(brands),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

export const findBrandsForCourse = (brandId) =>
    fetch(`${FOOTWEAR_URL}/${footwearId}/brands`)
        .then(response => response.json())

export const findBrandsById = (id) =>
    fetch(`${BRAND_URL}/${id}`)
        .then(response => response.json())

export const updateBrand = (id, brand) =>
    fetch(`${BRAND_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(brand),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

const deleteSection = (id) =>
    fetch(`${BRAND_URL}/${id}`, {
        method: "DELETE"
    })

export default {
    createBrandForFootwear,
    findBrandsForFootwear,
    findBrandById,
    updateBrand,
    deleteSection
}