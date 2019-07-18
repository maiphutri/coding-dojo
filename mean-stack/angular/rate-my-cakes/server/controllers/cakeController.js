const cakeQueries = require("../models/queries.cakes");

module.exports = {

  index(req, res) {
    cakeQueries.getAllCakes((err, cakes) => {
      if(err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", cakes: cakes});
      }
    })
  },

  show(req, res) {
    cakeQueries.getCake(req.params.id, (err, cake) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", cake: cake});
      }
    })
  },
  
  create(req, res) {
    cakeQueries.createCake(req.body, (err, cake) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", cake: cake});
      }
    })
  },

  update(req, res) {
    cakeQueries.updateCake(req.params.id, req.body, (err, cake) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", cake: cake});
      }
    })
  }
}