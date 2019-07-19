const express          = require("express"),
      router           = express.Router(),
      productController   = require("../controllers/productController");

router.get("/api/products", productController.products);
router.get("/api/products/:id", productController.show);
router.post("/api/products", productController.create);
router.post("/api/products/:id", productController.update);
router.get("/api/products/:id/delete", productController.destroy);

module.exports = router;