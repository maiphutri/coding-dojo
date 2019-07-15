const express          = require("express"),
      router           = express.Router(),
      userController   = require("../controllers/userController");

router.get("/", userController.index);
router.get("/new/:name", userController.new);
router.get("/remove/:name", userController.destroy);
router.get("/:name", userController.show);

module.exports = router;