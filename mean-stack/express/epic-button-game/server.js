const app     = require("./app");
      http    = require("http");
      server  = http.createServer(app);
      io      = require("socket.io")(server);
let counter = 0;
io.on("connection", socket => {
  socket.emit("greeting", {hello: "Hello! Socket connected."});
  
  socket.on("buttonClicked", data => {
    counter += data.counter;
    io.emit("updateCounter", {counter: counter});
  })
  
  socket.on("reset", data => {
    counter = data.counter;
    io.emit("reset", {counter: counter});
  })
  
})

server.listen(8000, () => {
  console.log("Server is listening on port 8000")
});