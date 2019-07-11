const app     = require("./app");
      http    = require("http");
      server  = http.createServer(app);
      io      = require("socket.io")(server);
let currentColor;
io.on("connection", socket => {

  socket.on("color", data => {
    currentColor = data.color;
    io.emit("color", {color: data.color})
  })

  socket.emit("new user", {color: currentColor});
  
})

server.listen(8000, () => {
  console.log("Server is listening on port 8000")
});