const app       = require("./app");
      http      = require("http");
      server    = http.createServer(app);
      io        = require("socket.io")(server);
      users     = [];
      messages  = [];
      
io.on("connection", socket => {

  socket.on("isNewUser", data => {
    const isNewUser = users.filter(user => user.userId == data.userId);
    if (isNewUser.length > 0) {
      socket.emit("isNewUser", {newUser: false});
      socket.emit("allMessages", {messages: messages});
    } else {
      socket.emit("isNewUser", {newUser: true});
      socket.on("addNewUser", data => {
        users.push(data);
      })
      socket.emit("allMessages", {messages: messages});
    }
  })

  socket.on("newMessage", data => {
    let user = users.find(user => user.userId == data.userId)
    messages.push({msg: data.msg, name: user.name, userId: data.userId});
    io.emit("messages", {msg: data.msg, name: user.name, userId: data.userId});
  })

  
})

server.listen(8000, () => {
  console.log("Server is listening on port 8000")
});