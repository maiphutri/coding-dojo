module.exports = {
  init(app) {
    const taskRoutes = require("../routes/tasks");
    
    app.use(taskRoutes);
  }
}