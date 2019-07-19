const productQueries = require("../models/queries.product");

module.exports = {

  products(req, res) {
    productQueries.getAllProducts((err, products) => {
      if(err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", products: products});
      }
    })
  },

  show(req, res) {
    productQueries.getProduct(req.params.id, (err, product) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", product: product});
      }
    })
  },
  
  create(req, res) {
    productQueries.createProduct(req.body, (err, product) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", product: product});
      }
    })
  },

  update(req, res) {
    productQueries.updateProduct(req.params.id, req.body, (err, product) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", product: product});
      }
    })
  },

  destroy(req, res) {
    productQueries.removeProduct(req.params.id, (err, product) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Successfully removed " + product.title});
      }
    })
  },
}