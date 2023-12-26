package com.web.homework.model;

import java.util.*;

public class RankList {
    private final static Map<String, Integer> rank = new HashMap<String, Integer>();

    public void set(String user, Integer cnt) {
        synchronized (rank) {
            rank.put(user, cnt);
        }
    }

    public int get(String user) {
        Integer count = rank.get(user);
        if (count != null) return count;
        else return 0;
    }

    public List<Rank> getRankListBySort() {
        List<Rank> ranks = new ArrayList<Rank>();
        for (String user : rank.keySet()) {
            ranks.add(new Rank(user, rank.get(user)));
        }
        Collections.sort(ranks);
        return ranks;
    }

    public void clear(String user) {
        rank.put(user, 0);
    }


    public class Rank implements Comparable {
        private String user;
        private Integer count;

        public Rank(String user, Integer count) {
            this.user = user;
            this.count = count;
        }

        public String getUser() {
            return user;
        }


        public Integer getCount() {
            return count;
        }

        public int compareTo(Object o) {
            return count - ((Rank) o).count;
        }
    }
}

