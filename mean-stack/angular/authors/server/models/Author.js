const mongoose = require("mongoose"),
      shortid  = require("shortid");

mongoose.Promise = require("bluebird");
mongoose.connect("mongodb://localhost/authors", {useNewUrlParser: true, useFindAndModify: false})

const AuthorSchema = new mongoose.Schema({
  _id: {
    type: String,
    default: shortid.generate
  },
  name: {type: String, minlength: [3, "Name must be at least 3 characters."]}
}, {timestamps: true});

mongoose.model("Author", AuthorSchema);
const Author = mongoose.model("Author");

module.exports = Author;