package it.progetto.progetto.DTO;

public class ProductDTO {


    private int id;
    private String name;
    private Long nrAcquisti;

    public ProductDTO(int id, String name, Long nrAcquisti) {
        this.id = id;
        this.name = name;
        this.nrAcquisti = nrAcquisti;
    }

    public ProductDTO() {
    }

    public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

    public Long getNrAcquisti() {
        return nrAcquisti;
    }

    public void setNrAcquisti(Long nrAcquisti) {
                this.nrAcquisti = nrAcquisti;
        }
}
