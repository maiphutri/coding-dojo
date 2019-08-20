const Author = require("./Author");

module.exports = {
  getAllAuthors(callback) {
    Author.find({}).then(authors => {
      callback(null, authors);
    })
    .catch(err => callback(err));
  },

  createAuthor(postData, callback) {
    let newAuthor = new Author(postData);
    newAuthor.save().then(author => {
      callback(null, author);
    })
    .catch(err => callback(err));
  },

  updateAuthor(id, postData, callback) {
    Author.findByIdAndUpdate(id, {$set: postData}, {new: true}).then(author => {
      callback(null, author);
    })
    .catch(err => callback(err));
  }
}