const User        = require("../models/User"),
      bcrypt      = require("bcrypt"),
      userQueries = require("../models/queries.users");

module.exports = {
  index(req, res) {
    if ("errors" in req.session === false) {
      req.session.errors = {
        firstName: "",
        lastName: "",
        email: ""
      }
    }
    res.render("index", {errors: req.session.errors});
  },

  reg(req, res) {
    userQueries.createUser(req, (err, user) => {
      if(err) {
        res.redirect("/");
      } else {
        res.redirect("/success");
      }
    });
  },

  logIn(req, res) {
    userQueries.logIn(req, (err, result) => {
      if(err) {
        res.redirect("/");
      } else {
        res.redirect("/success");
      }
    })
  },

  logOut(req, res) {
    res.locals.currentUser = null;
    req.session.destroy();
    res.redirect("/");
  },

  success(req, res) {
    res.locals.currentUser = req.session.user;
    res.render("success");
  }
}