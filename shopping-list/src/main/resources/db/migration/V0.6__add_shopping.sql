create table SHOPPING_LIST (
                               SHOPPINGLISTID UUID,
                               NAME TEXT,
                               COCKTAILID UUID,
                               PRIMARY KEY(SHOPPINGLISTID),
                               FOREIGN KEY(COCKTAILID)
                           REFERENCES COCKTAIL(COCKTAILID)
);