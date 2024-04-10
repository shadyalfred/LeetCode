class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int[] sortedDeck = new int[deck.length];

        Queue<Integer> qOfIndecies = IntStream.range(0, deck.length).boxed().collect(
            Collectors.toCollection(LinkedList::new)
        );

        for (int card : deck) {
            int i = qOfIndecies.remove();
            sortedDeck[i] = card;
            if (!qOfIndecies.isEmpty()) {
                qOfIndecies.add(qOfIndecies.remove());
            }
        }

        return sortedDeck;
    }
}