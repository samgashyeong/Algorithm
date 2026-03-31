#include <stdio.h>
int main() {


    int n = 0;

    scanf("%d", &n);

    int d = n;
    int ans = 0;
    while (1) {
        int a = d/10;
        int b = d%10;

        int result = a+b;

        int ra = result%10;


        d = b*10+ra;

        //printf("%d\n", d);
        ans++;
        if (d == n) {
            printf("%d", ans);
            return 0;
        }

    }
    return 0;
    // TIP See CLion help at <a href="https://www.jetbrains.com/help/clion/">jetbrains.com/help/clion/</a>. Also, you can try interactive lessons for CLion by selecting 'Help | Learn IDE Features' from the main menu.
}