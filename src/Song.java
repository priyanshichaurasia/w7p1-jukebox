public class Song {

        private int sId,artId, albId, gId;
        private String sName, timeDuration;

        public Song(int sId, String sName, String timeDuration, int artId, int albId, int gId){
            this.sId=sId;
            this.sName=sName;
            this.timeDuration=timeDuration;
            this.artId=artId;
            this.albId=albId;
            this.gId=gId;
        }

    public Song(String sName, String timeDuration, int artId, int albId, int gId){
        this.sName=sName;
        this.timeDuration=timeDuration;
        this.artId=artId;
        this.albId=albId;
        this.gId=gId;
    }


        public int getSId() {
            return sId;
        }

        public void setSId(int sId) {
            this.sId = sId;
        }

        public String getSName() {
            return sName;
        }

        public void setSName(String sName) {
            this.sName = sName;
        }

        public String getTimeDuration() {
            return timeDuration;
        }

        public void setTimeDuration(String timeDuration) {
            this.timeDuration = timeDuration;
        }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public int getAlbId() {
        return albId;
    }

    public void setAlbId(int albId) {
        this.albId = albId;
    }

    public int getGId() {
        return gId;
    }

    public void setGId(int gId) {
        this.gId = gId;
    }

    @Override
        public String toString(){
            return (sId +" "+ sName +" "+ timeDuration +" "+ artId +" "+ albId +" "+ gId);
        }
    }
