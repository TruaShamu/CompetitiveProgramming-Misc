import java.io.*;
import java.util.*;

public class horrible {
	public static final int MAXN = 100005;
	public static long[] lazy = new long[4 * MAXN];
	public static long[] seg = new long[4 * MAXN];
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int tc = io.nextInt();
		while (tc-- > 0) {
			int N = io.nextInt();
			int Q = io.nextInt();
			Arrays.fill(lazy, 0);
			build(0, N - 1, 0);
			while (Q-- > 0) {
				int type = io.nextInt();
				if (type == 0) {
					// Update elements from p to q.
					int p = io.nextInt() - 1;
					int q = io.nextInt() - 1;
					int val = io.nextInt();
					update(0, N-1, p, q, 0, val);
				} else {
					// Query sum of elements from p to q.
					int p = io.nextInt() - 1;
					int q = io.nextInt() - 1;
					io.println(query(0, N-1, p, q, 0));
				}
			}
		}
		io.close();
	}

	/*
	 * Update range [lowQ, highQ] by adding val.
	 * In and out is the lower and upperbounds
	 *  of the range of the node in the segtree.
	 */
	public static void update(int start, int end, int lowQ, int highQ, int node,  long  val) {
		if (lazy[node] > 0) {
			seg[node] += (end - start + 1) * lazy[node];
			if (end != start) {
				lazy[2 * node + 1] += lazy[node];
				lazy[2 * node + 2] += lazy[node];
			}
			lazy[node] = 0;
		}
		if (start > highQ || end < lowQ) {
			return;
		}
		// The current segment is encompassed by [lowQ, highQ]
		if (lowQ <= start && end <= highQ) {
			seg[node] += (end - start + 1) * val;
			if (end != start) {
				lazy[2 * node + 1] += val;
				lazy[2 * node + 2] += val;
			}
			return;
		}
		// Update the left and right child.
		int mid = start + end >> 1;
		update(start, mid, lowQ, highQ, 2 * node + 1, val);
		update(mid + 1, end, lowQ, highQ, 2 * node + 2, val);
		seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
	}


	// Query the sum of the elements in range [lowQ, highQ]
	public static long query(int start, int end, int lowQ, int highQ, int node) {
		// Update the node.
		if (lazy[node] > 0) {
			seg[node] += (end - start + 1) * lazy[node];
			// Mark the children as lazy.
			if (end != start) {
				lazy[2 * node + 1] += lazy[node];
				lazy[2 * node + 2] += lazy[node];
			}
			lazy[node] = 0;
		}
		if (start > highQ || end < lowQ) {
			return 0;
		}
		if (lowQ <= start && end <= highQ){
			return seg[node];
		}
		// Query from the left and right child.
		int mid = start + end >> 1;
		long leftChild = query(start, mid, lowQ, highQ, 2 * node + 1);
		long rightChild = query(mid + 1, end, lowQ, highQ, 2 * node + 2);
		return (leftChild + rightChild);
	}

	// Build and initialize the segment tree.
	public static void build(int low, int high, int node) {
		// Out of range.
		if (low > high) {
			return;
		}
		// This is a leaf node.
		if (low == high) {
			seg[node] = 0;
			return;
		}
		// Build left and right child.
		int mid = (low + high) / 2;
		int left = 2 * node + 1;
		int right = 2 * node + 2;
		build(low, mid, left);
		build(mid + 1, high, right);
		seg[node] = seg[left] + seg[right];
	}

	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;

		// standard input
		public Kattio() {
			this(System.in, System.out);
		}

		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}

		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(new FileWriter(problemName + ".out"));
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}

		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) {
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
