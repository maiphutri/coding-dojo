const mongoose = require("mongoose");
      validate = require("mongoose-validator");

mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/log-reg")

let nameValidator = [
  validate({
    validator: 'isLength',
    arguments: [2],
    message: "First name and last name should be at least 2 characters"
  }),
]


const UserSchema = new mongoose.Schema({
  firstName: {type: String, required: true, validate: nameValidator},
  lastName: {type: String, required: true, validate: nameValidator},

}, { timestamps: true})

mongoose.model("User", UserSchema);

const User = mongoose.model("User");

module.exports = User;