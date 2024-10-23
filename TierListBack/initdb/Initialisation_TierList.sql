INSERT INTO users (username, mail, mdp) VALUES ('Username1', 'Mail1', 'MDP1');

INSERT INTO tierlists (tierlisttitle, publictierlist, votepour, votecontre, creationdate, owner_id) VALUES ('Titre TierList1', true,0,0, current_date,1);

INSERT INTO tiers (tiertitle,tierlist_id) VALUES ('Titre Tier1',1);
INSERT INTO tiers (tiertitle,tierlist_id) VALUES ('Titre Tier2',1);

INSERT INTO items (itemtitle,itemURL,tier_id) VALUES ('Titre Item1','URL item1',1);
INSERT INTO items (itemtitle,itemURL,tier_id) VALUES ('Titre Item2','URL item2',1);
INSERT INTO items (itemtitle,itemURL,tier_id) VALUES ('Titre Item3','URL item3',2);







