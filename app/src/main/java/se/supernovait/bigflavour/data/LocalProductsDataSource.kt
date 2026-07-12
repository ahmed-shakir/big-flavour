package se.supernovait.bigflavour.data

import se.supernovait.bigflavour.R
import se.supernovait.bigflavour.domain.model.product.ProductCategory
import se.supernovait.bigflavour.domain.model.product.ProductItem

object LocalProductsDataSource {

    fun getProducts() =
        mutableListOf(
            ProductItem("Black tea", "A robust, amber infusion of hand-selected leaves, steeped to perfection and served with quiet ceremony.", ProductCategory.DRINK, 3.00, R.drawable.drink_black_tea),
            ProductItem("Green tea", "Delicate and grassy, this fine-leaf infusion offers a moment of subtle refinement in every cup.", ProductCategory.DRINK, 3.00, R.drawable.drink_green_tea),
            ProductItem("Espresso", "A rich, velvety shot pulled from artisan-roasted beans, delivering bold intensity in a single, perfect sip.", ProductCategory.DRINK, 5.00, R.drawable.drink_espresso),
            ProductItem("Cappuccino", "Silken espresso crowned with a cloud of hand-frothed milk, finished with a delicate dusting of cocoa.", ProductCategory.DRINK, 8.00, R.drawable.drink_cappuccino),
            ProductItem("Latte", "Smooth espresso layered beneath steamed milk, poured with artful precision for a gentle, comforting balance.", ProductCategory.DRINK, 8.00, R.drawable.drink_latte),
            ProductItem("Mocha", "A luxurious marriage of dark chocolate and espresso, softened with steamed milk into a decadent indulgence.", ProductCategory.DRINK, 10.00, R.drawable.drink_mocha),
            ProductItem("Boeuf bourguignon", "Tender beef braised for hours in rich Burgundy wine, with pearl onions and mushrooms, a timeless French classic.", ProductCategory.FOOD, 15.00, R.drawable.dish_boeuf_bourguignon),
            ProductItem("Bouillabaisse", "An aromatic Provençal fish stew, simmered with saffron and fennel, served with a rustic rouille.", ProductCategory.FOOD, 20.00, R.drawable.dish_bouillabaisse),
            ProductItem("Lasagna", "Layers of house-made pasta, slow-cooked ragù, and creamy béchamel, baked to golden, bubbling perfection.", ProductCategory.FOOD, 15.00, R.drawable.dish_lasagna),
            ProductItem("Onion soup", "Caramelized onions in a deep, savory broth, crowned with a crust of melted Gruyère and toasted bread.", ProductCategory.FOOD, 12.00, R.drawable.dish_onion_soup),
            ProductItem("Salmon en papillote", "Fresh salmon delicately steamed in parchment with herbs and citrus, sealing in every nuance of flavor.", ProductCategory.FOOD, 25.00, R.drawable.dish_salmon_en_papillote),
            ProductItem("Quiche Lorraine", "A buttery, flaky pastry filled with silken egg custard, smoked lardons, and aged cheese.", ProductCategory.DESSERT, 17.00, R.drawable.dish_quiche_lorraine),
            ProductItem("Custard tart", "A crisp, golden shell cradling a luxuriously smooth vanilla custard, kissed with a hint of nutmeg.", ProductCategory.DESSERT, 14.00, R.drawable.dessert_custard_tart),
            ProductItem("Croissant", "Buttery, hand-laminated layers baked to a delicate crackle, an emblem of French pastry artistry.", ProductCategory.DESSERT, 7.00, R.drawable.dessert_croissant),
        )
}
