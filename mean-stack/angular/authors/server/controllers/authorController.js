const authorQueries = require("../models/queries.authors");

module.exports = {
  index(req, res) {
    authorQueries.getAllAuthors((err, authors) => {
      if (err) {
        res.json(err)
      } else {
        res.json(authors)
      }
    })
  },

  create(req, res) {
    authorQueries.createAuthor(req.body, (err, author) => {
      if (err) {
        res.json(err);
      } else {
        res.json(author)
      }
    })
  },

  update(req, res) {
    authorQueries.updateAuthor(req.params.id, req.body, (err, author) => {
      if (err) {
        res.json(err);
      } else {
        res.json(author)
      }
    })
  }
}