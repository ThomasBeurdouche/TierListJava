INSERT INTO tierlists (tierlisttitle, publictierlist, votepour, votecontre, creationdate, owner_id) VALUES ('Titre TierList1', true,0,0, current_date,1);

INSERT INTO users (username, mail, mdp) VALUES ('Username1', 'Mail1', 'MDP1');

INSERT INTO tiers (tiertitle) VALUES ('Titre Tier1');
INSERT INTO tiers (tiertitle) VALUES ('Titre Tier2');

INSERT INTO items (itemtitle) VALUES ('Titre Item1');
INSERT INTO items (itemtitle) VALUES ('Titre Item2');
INSERT INTO items (itemtitle) VALUES ('Titre Item3');

INSERT INTO tierlist_tier (tierlist_id, tier_id) VALUES (1, 1);
INSERT INTO tierlist_tier (tierlist_id, tier_id) VALUES (1, 2);

INSERT INTO tier_item (tier_id, item_id) VALUES (1, 1);
INSERT INTO tier_item (tier_id, item_id) VALUES (1, 2);
INSERT INTO tier_item (tier_id, item_id) VALUES (2, 3);







