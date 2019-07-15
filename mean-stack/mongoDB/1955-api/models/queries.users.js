const User        = require("./User");

module.exports = {
  getAllUsers(callback) {
    User.find({}).then(users => {
      callback(null, users)
    })
    .catch(err => {
      callback(null);
    })
  },

  createUser(name, callback) {
    let newUser = new User({name: name});
    newUser.save().then(user => {
      callback(null, user);
    })
    .catch(err => callback(err));
  },

  removeUser(name, callback) {
    User.findOne({name: name}).then(user => {
      user.remove().then(() => {
        callback(null, user);
      })
      .catch(err => callback(err));
    })
    .catch(err => callback(err));
  },

  getUser(name, callback) {
    User.findOne({name: name}).then(user => {
      callback(null, user);
    })
    .catch(err => callback(err));
  }
}
