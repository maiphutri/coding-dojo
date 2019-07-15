const express          = require("express"),
      router           = express.Router(),
      userController   = require("../controllers/userController");

router.get("/", userController.index);
router.post("/registration", userController.reg);
router.post("/login", userController.logIn);
router.get("/logout", userController.logOut);
router.get("/success", userController.success);
module.exports = router;