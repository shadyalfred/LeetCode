class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int[] sortedDeck = new int[deck.length];

        Queue<Integer> q = IntStream.range(0, deck.length).boxed().collect(
            Collectors.toCollection(LinkedList::new)
        );

        for (int card : deck) {
            int i = q.remove();
            sortedDeck[i] = card;
            if (!q.isEmpty()) {
                q.add(q.remove());
            }
        }

        return sortedDeck;
    }
}