const app     = require("./app");
      http    = require("http");
      server  = http.createServer(app);
      io      = require("socket.io")(server);

io.on("connection", socket => {
  socket.emit("greeting", {hello: "Hello! Socket connected."});
  socket.on("thank you", data => {
    console.log(data);
  })
  socket.on("posting form", data => {
    let rand = Math.floor(Math.random() * 1000) + 1;
    console.log(data);
    socket.emit("updated message", {...data, rand});
  })
})

server.listen(8000, () => {
  console.log("Server is listening on port 8000")
});