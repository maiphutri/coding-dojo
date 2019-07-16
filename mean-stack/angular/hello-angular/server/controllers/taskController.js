const Task        = require("../models/Task"),
      taskQueries = require("../models/queries.tasks");

module.exports = {

  tasks(req, res) {
    taskQueries.getAllTasks((err, tasks) => {
      if(err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", data: tasks});
      }
    })
  },

  show(req, res) {
    taskQueries.getTask(req.params.id, (err, task) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", data: task});
      }
    })
  },
  
  create(req, res) {
    taskQueries.createTask(req.body, (err, task) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", data: task});
      }
    })
  },

  update(req, res) {
    taskQueries.updateTask(req.params.id, req.body, (err, task) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Success", data: task});
      }
    })
  },

  destroy(req, res) {
    taskQueries.removeTask(req.params.id, (err, task) => {
      if (err) {
        res.json({message: "Error", error: err});
      } else {
        res.json({message: "Successfully removed " + task.title});
      }
    })
  },
}