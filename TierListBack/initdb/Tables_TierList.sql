create table tierLists
(
    id SERIAL PRIMARY KEY,
    tierListTitle TEXT not null,
    publicTierList BOOLEAN null,
    votePour int null,
    voteContre int null,
    creationDate date not null,
    owner_id int not null
);

create table tiers
(
    id SERIAL PRIMARY KEY,
    tierTitle TEXT not null
);

create table items
(
    id SERIAL PRIMARY KEY,
    itemTitle TEXT not null
);

create table "users"
(
    id SERIAL PRIMARY KEY,
    username TEXT not null,
    mail TEXT not null,
    mdp TEXT not null
);

create table tierList_tier
(
    id SERIAL PRIMARY KEY,
    tierList_id int not null,
    tier_id int not null
);

create table tier_item
(
    id SERIAL PRIMARY KEY,
    tier_id int not null,
    item_id int not null
);