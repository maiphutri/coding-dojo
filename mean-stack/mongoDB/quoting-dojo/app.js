const express   = require("express");
      app       = express();
      appConfig = require("./main-config");
      Quote     = require("./models");
      moment    = require("moment");


appConfig.init(app, express);

app.get("/", (req, res) => {
  res.render("index");
})

app.get("/quotes", (req, res) => {
  Quote.find({}, null, {sort: {created_at: -1}}, (err, quotes) => {
    if (err) {
      console.log(err);
      res.redirect(500, err);
    } else {
      console.log(quotes);
      res.render("quotes", {quotes: quotes, moment: moment})
    }
  })

})

app.post("/quotes", (req, res) => {
  let quote = new Quote({name: req.body.name, quote: req.body.quote});
  console.log(quote);
  quote.save()
    .then(console.log("Successfully created new quote"))
    .catch(err => console.log(err));
  res.redirect("/quotes");
})

app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;