public class Series {
    private String name;
    private String runtimeOfSeries;
    private String certificate;
    private String runtimeOfEpisodes;
    private String genre;
    private double imdbRating;
    private String overview;
    private int numberOfVotes;
    private int id;

    public Series(String name, String runtimeOfSeries, String certificate, String runtimeOfEpisodes, String genre, double imdbRating, String overview, int numberOfVotes, int id) {
        this.name = name;
        this.runtimeOfSeries = runtimeOfSeries;
        this.certificate = certificate;
        this.runtimeOfEpisodes = runtimeOfEpisodes;
        this.genre = genre;
        this.imdbRating = imdbRating;
        this.overview = overview;
        this.numberOfVotes = numberOfVotes;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuntimeOfSeries() {
        return runtimeOfSeries;
    }

    public void setRuntimeOfSeries(String runtimeOfSeries) {
        this.runtimeOfSeries = runtimeOfSeries;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getRuntimeOfEpisodes() {
        return runtimeOfEpisodes;
    }

    public void setRuntimeOfEpisodes(String runtimeOfEpisodes) {
        this.runtimeOfEpisodes = runtimeOfEpisodes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
