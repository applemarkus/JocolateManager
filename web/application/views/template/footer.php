<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>
</div>
<footer class="footer">
	<div class="container">
		<p class="text-muted">Page rendered in <strong>{elapsed_time}</strong> seconds. <?php echo (ENVIRONMENT === 'development') ? 'CodeIgniter Version <strong>' . CI_VERSION . '</strong>' : '' ?></p>
	</div>
</footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="<?php echo base_url(); ?>assets/js/bootstrap.js"></script>
    </body>
    </html>