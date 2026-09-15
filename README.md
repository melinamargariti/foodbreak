# foodbreak
Exercise B from GRCPC 2025

Alex is organizing the next coding bootcamp at your university. Between managing speakers, coordinating with professors and answering questions in Discord, he's forgotten to plan the most crucial part: lunch breaks.

The bootcamp day starts at time 0
 and lasts T
 units of time. Alex has scheduled N
 presentations, where presentation i
 occupies the time interval [si,ei)
. To arrange the food break, Alex needs to find the largest gap between presentations.

A gap is a maximal time interval [a,b)
 during the day where no presentations are scheduled (that is, 0≤a<b≤T
 and no presentation overlaps with [a,b)
). Your task is to find the length of the largest gap.

Input
The first line contains two integers N
 (1≤N≤105
) and T
 (1≤T≤109
) — the number of presentations and the length of the day.

Each of the next N
 lines contains two integers si
 and ei
 (0≤si<ei≤T
) — the start and end times of presentation i
. Presentation i
 occupies the half-open interval [si,ei)
, meaning it includes time si
 but not time ei
.

Output
Output one integer — the length of the largest gap between presentations.


EXAMPLE

input:
4 60
5 10
50 55
25 30
15 20

output:
20

