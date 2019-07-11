const http = require("http");
      fs   = require("fs");
      url  = require('url');
      path = require("path");

const server = http.createServer((req, res) => {

  if (req.url === "/cars") {
    fs.readFile("views/cars.html", 'utf8', (err, data) => {
      res.writeHead(200, {"Content-Type": "text/html"});
      res.write(data);
      res.end();
    })
  }

  if (req.url === "/cats") {
    fs.readFile("views/cats.html", 'utf8', (err, data) => {
      res.writeHead(200, {"Content-Type": "text/html"});
      res.write(data);
      res.end();
    })
  }

  if (req.url === "/cars/new") {
    fs.readFile("views/car-new.html", 'utf8', (err, data) => {
      res.writeHead(200, {"Content-Type": "text/html"});
      res.write(data);
      res.end();
    })
  }

  if (req.url === "/stylesheets/style.css") {
    fs.readFile("stylesheets/style.css", 'utf8', (err, data) => {
      res.writeHead(200, {"Content-Type": "text/css"});
      res.write(data);
      res.end();
    })
  }

  if (req.url.endsWith("jpeg")) {
    let parsed = url.parse(req.url, true);
    let filename = path.basename(parsed.pathname);
    fs.readFile("images/" + filename, (err, img) => {
      res.writeHead(200, {"Content-Type": "images/jpeg"});
      res.write(img);
      res.end();
    })
  }
})

server.listen(7077)
console.log("Server is running on port 7077")
