const app     = require("./app");
      http    = require("http");
      server  = http.createServer(app);

app.listen(8000, () => {
  console.log("Server is listening on port 8000")
});