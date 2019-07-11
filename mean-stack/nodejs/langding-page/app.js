const http    = require("http"),
      fs      = require("fs"),
      url     = require("url"),
      path    = require("path");

const server = http.createServer((req, res) => {
  console.log("client request URL:", req.url);
  if ( req.url === "/") {
    fs.readFile("index.html", "utf8", (err, data) => {
      res.writeHead(200, {"Content-Type": "text/html"});
      res.write(data);
      res.end();
    })
  } else if (req.url === '/ninjas') {
    fs.readFile("ninjas.html", "utf8", (err, data) => {
      res.writeHead(200, {"Content-Type": "text/html"});
      res.write(data);
      res.end();
    })
  } else if (req.url === '/dojos/new') {
    fs.readFile("dojos.html", "utf8", (err, data) => {
      res.writeHead(200, {"Content-Type": "text/html"});
      res.write(data);
      res.end();
    })
  } else if (req.url === '/styles.css') {
    fs.readFile("styles.css", "utf8", (err, data) => {
      res.writeHead(200, {"Content-Type": "text/css"});
      res.write(data);
      res.end();
    })
  } else if (req.url.endsWith("jpg") || req.url.endsWith("png") || req.url.endsWith("gif")) { 
    let parsed =  url.parse(req.url, true);
    let filename = path.basename(parsed.pathname); //get the filename from the url
    fs.readFile("assets/images/" + filename, (err, img) => { // don't use utf8 when send image in response
      res.writeHead(200, {'Content-Type': 'image/*' });
      res.end(img);
    })
  } else {
    res.end("File not found")
  }
})

server.listen(5000);
console.log("Server is running at port 5000");