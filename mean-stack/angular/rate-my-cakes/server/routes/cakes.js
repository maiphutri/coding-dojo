const express          = require("express"),
      router           = express.Router(),
      cakeController   = require("../controllers/cakeController");

router.get("/cakes", cakeController.index);
router.get("/cakes/:id", cakeController.show);
router.post("/cakes", cakeController.create);
router.post("/cakes/:id", cakeController.update);

module.exports = router;