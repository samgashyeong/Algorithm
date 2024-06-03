#include <stdio.h>
#define MAX 1001
#define INFI 987654321
int D[MAX];
int Visited[MAX];
int Map[MAX][MAX];

void Dijkstra(int maxV, int startV, int destV) {
	for (int i = 1; i <= maxV; i++) {
		D[i] = INFI;
	}
	D[startV] = 0;
	for (int i = 1; i <= maxV; i++) {
		int min = INFI;
		for (int j = 1; j <= maxV; j++) {
			if (!Visited[j] && min > D[j]) {
				min = D[j];
				startV = j;
			}
		}
		Visited[startV] = 1;
		for (int nextV = 1; nextV <= maxV; nextV++) {
			if (Map[startV][nextV] != INFI && D[nextV] > D[startV] + Map[startV][nextV]) {
				D[nextV] = D[startV] + Map[startV][nextV];
			}
		}
	}
	printf("%d\n", D[destV]);
}

void initMap() {
	for (int y = 0; y < MAX; y++) {
		for (int x = 0; x < MAX; x++) {
			Map[y][x] = INFI;
		}
	}
}

int main(void) {
	int S = 0;
	int D = 0;
	int N = 0;
	int M = 0;
	initMap();
	scanf("%d", &N);
	scanf("%d", &M);

	for (int i = 0; i < M; i++) {
		int s = 0;
		int d = 0;
		int w = 0;

		scanf("%d %d %d", &s, &d, &w);
		if (Map[s][d] > w) {
			Map[s][d] = w;
		}
	}

	scanf("%d %d", &S, &D);

	Dijkstra(N, S, D);

	return 0;
}