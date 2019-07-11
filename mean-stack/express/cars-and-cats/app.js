const express   = require("express");
      app       = express();
      appConfig = require("./main-config");

let cats = [
  {
    id: 1,
    name: "Cuddle",
    favFood: "Spaghetti",
    age: 3,
    sleepSpots: ["under the bed", "in a sunbeam"],
    img: "cat1.jpeg"
  },
  {
    id:2,
    name: "Aldo",
    favFood: "Steak",
    age: 5,
    sleepSpots: ["in a box", "on the tree"],
    img: "cat2.jpeg"
  },
  {
    id:3,
    name: "Toby",
    favFood: "Burger",
    age: 2,
    sleepSpots: ["in the restroom", "in the sink"],
    img: "cat3.jpeg"
  },
];

appConfig.init(app, express);

app.get("/cars", (req, res) => {
  res.render("cars");
})

app.get("/cats", (req, res) => {
  res.render("cats/index");
})

app.get("/cats/:id", (req, res) => {
  let result;
  cats.forEach(cat => {
    if (cat.id == req.params.id) {
      result = cat;
    }
  })
  console.log(result);
  res.render("cats/show", {cat: result});
})

app.get("/cars/new", (req, res) => {
  res.render("form");
})

app.get("*", (req, res) => {
  res.send("404 Page Not Found!");
})

module.exports = app;