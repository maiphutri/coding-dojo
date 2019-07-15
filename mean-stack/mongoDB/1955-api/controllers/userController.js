const User        = require("../models/User"),
      userQueries = require("../models/queries.users");

module.exports = {
  index(req, res) {
    userQueries.getAllUsers((err, users) => {
      if(err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", data: users});
      }
    })
  },
  
  new(req, res) {
    userQueries.createUser(req.params.name, (err, user) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", data: user});
      }
    })
  },

  destroy(req, res) {
    userQueries.removeUser(req.params.name, (err, user) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Successfully removed " + user.name});
      }
    })
  },

  show(req, res) {
    userQueries.getUser(req.params.name, (err, user) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", data: user});
      }
    })
  }
}