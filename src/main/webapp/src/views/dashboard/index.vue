<template>
  <div :style="{backgroundImage: 'url(' + imageUrl + ')'}">
  </div>

</template>

<script>

export default {
  name: 'DashBord',
  data(){
    return {
      imageUrl :''
    }
  },
  created() {
    this.$axios.get("/rest/everyDayImage/get").then(res => {
      this.imageUrl = res.data;
    });
  }
}

</script>

<style>

</style>