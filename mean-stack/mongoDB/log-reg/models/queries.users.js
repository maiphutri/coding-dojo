const User        = require("./User"),
      bcrypt      = require("bcrypt"),
      validators  = require("./validators");

module.exports = {
  createUser(req, callback) {
    let errors = validators.userValidator(req.body);
    User.findOne({email: req.body.email}).then(user => {
      if (user) {
        errors.email = "Email is already existed";
      }
    
      if (Object.entries(errors).length > 0) {
        req.session.errors = req.body
        for (let key in errors) {
          req.flash(key, errors[key]);
        }
        return callback(errors);
      }
      bcrypt.hash(req.body.password, 10).then(pw => {
        let userInput = {
          firstName: req.body.firstName,
          lastName: req.body.lastName,
          email: req.body.email,
          password: pw
        }

        let newUser = new User(userInput);
        req.session.reg = req.body
        newUser.save().then(user => {
          console.log("Created new user");
          delete req.session.errors;
          req.session.user = {
            id: user.id,
            firstName: user.firstName
          }
          callback(null, user)
        })
        .catch(err => console.log(err))
      })
      .catch(err => console.log(err))
    })
    .catch(err => console.log(err))
  },

  logIn(req, callback) {
    User.findOne({email: req.body.email}).then(user => {
      req.session.errors = { emailLog: req.body.email };
      if (!user) {
        req.flash("emailLog", "This email is not yet registered");
        return callback(true);
      }
      if (!req.body.password) {
        req.flash("pw", "Please type in your password");
        return callback(true);
      }
      bcrypt.compare(req.body.password, user.password).then(result => {
        if (result) {
          req.session.user = {
            id: user.id,
            firstName: user.firstName
          }
          delete req.session.errors;
          return callback(null, result);
        }
        req.flash("pw", "Wrong password");
        return callback(true);
      })
      .catch(err => console.log(err));
    })
    .catch(err => console.log(err));
  }
}
