<template>
  <div>{{ msg }}</div>

</template>
<script>
  import axios from 'axios'
  export default {
    data() {
      return {
        msg: ''
      }
    },
    created() {
      axios.get('/rest/hello').then(res=>{
        this.data.msg = res;
      });
    }
  }
</script>
<style lang="less">

</style>