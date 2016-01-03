package com.sb.rpg;

import java.util.Collection;
import java.util.LinkedList;

public class FeatsList {

    protected Collection<Feat> feats;

    protected FeatsList(Collection<Feat> feats) {
	this.feats = feats;
    }

    public FeatsList() {
	this.feats = new LinkedList<Feat>();
    }

    public boolean hasFeat(String name) {
	for (Feat feat : feats)
	    if (feat.getName().equalsIgnoreCase(name))
		return true;
	return false;
    }
    
    public boolean hasFeat(Feat feat) {
	for (Feat f : feats)
	    if (f.equals(feat))
		return true;
	return false;
    }
    
    public void add(Feat f) {
	feats.add(f);
    }
    
    public boolean remove(Feat f) {
	return feats.remove(f);
    }
}
