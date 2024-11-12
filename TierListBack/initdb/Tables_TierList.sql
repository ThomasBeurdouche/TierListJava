create table "users"
(
    id SERIAL PRIMARY KEY,
    username TEXT not null,
    mail TEXT not null,
    mdp TEXT not null
);

create table tierLists
(
    id SERIAL PRIMARY KEY,
    tierListTitle TEXT not null,
    publicTierList BOOLEAN null,
    votePour INT not null ,
    voteContre INT not null ,
    creationDate date not null,
    owner_id INT,
    CONSTRAINT fk_user
        FOREIGN KEY (owner_id)
        REFERENCES users(id)
        ON DELETE CASCADE  -- Optionnel : si vous voulez que la suppression d'une TierList supprime aussi les Tiers associés
);

create table tiers
(
    id SERIAL PRIMARY KEY,
    tierTitle TEXT not null,
    tierlist_id INT NOT NULL,
    CONSTRAINT fk_tierlist
        FOREIGN KEY (tierlist_id)
        REFERENCES tierlists(id)
        ON DELETE CASCADE  -- Optionnel : si vous voulez que la suppression d'une TierList supprime aussi les Tiers associés
);

create table items
(
    id SERIAL PRIMARY KEY,
    itemTitle TEXT not null,
    itemURL TEXT,
    tier_id INT NOT NULL,
    CONSTRAINT fk_tier
        FOREIGN KEY (tier_id)
        REFERENCES tiers(id)
        ON DELETE CASCADE  -- Optionnel : si vous voulez que la suppression d'une TierList supprime aussi les Tiers associés
);