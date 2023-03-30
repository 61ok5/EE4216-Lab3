const app = new Vue({
    el: '#app',
    data: {
        rows: [],
        editForm: {
            id: null,
            name: '',
            year: null,
            rank: null
        }
    },
    created() {
        this.fetchMovies();
    },
    methods: {
        async fetchMovies() {
            const response = await fetch('/api/movies');
            this.rows = await response.json();
        },
        editMovie(row) {
            this.editForm.id = row.id;
            this.editForm.name = row.name;
            this.editForm.year = row.year;
            this.editForm.rank = row.rank;
        },
        async saveMovie() {
            const response = await fetch(`/api/movies/${this.editForm.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.editForm)
            });

            if (response.ok) {
                await this.fetchMovies();
                this.editForm.id = null;
            }
        },
        async deleteMovie(row) {
            const response = await fetch(`/api/movies/${row.id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                this.rows = this.rows.filter(movie => movie.id !== row.id);
            }
        }
    }
});
