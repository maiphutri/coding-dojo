const express          = require("express"),
      router           = express.Router(),
      taskController   = require("../controllers/taskController");

router.get("/", taskController.index);
router.get("/tasks", taskController.tasks);
router.get("/tasks/:id", taskController.show);
router.post("/tasks", taskController.create);
router.post("/tasks/:id", taskController.update);
router.get("/tasks/:id/delete", taskController.destroy);

module.exports = router;