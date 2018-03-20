namespace GoogleMaps
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.panel1 = new System.Windows.Forms.Panel();
            this.epsilonBox = new System.Windows.Forms.NumericUpDown();
            this.label2 = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.ipBox = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.queryValue = new System.Windows.Forms.Label();
            this.queryLabel = new System.Windows.Forms.Label();
            this.rateValue = new System.Windows.Forms.Label();
            this.timeValue = new System.Windows.Forms.Label();
            this.rateLabel = new System.Windows.Forms.Label();
            this.timelabel = new System.Windows.Forms.Label();
            this.simplifyButton = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.rawDataBrowser = new System.Windows.Forms.WebBrowser();
            this.panel3 = new System.Windows.Forms.Panel();
            this.resultBrowser = new System.Windows.Forms.WebBrowser();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.epsilonBox)).BeginInit();
            this.panel2.SuspendLayout();
            this.panel3.SuspendLayout();
            this.SuspendLayout();
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.panel1.Controls.Add(this.epsilonBox);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.button2);
            this.panel1.Controls.Add(this.ipBox);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.queryValue);
            this.panel1.Controls.Add(this.queryLabel);
            this.panel1.Controls.Add(this.rateValue);
            this.panel1.Controls.Add(this.timeValue);
            this.panel1.Controls.Add(this.rateLabel);
            this.panel1.Controls.Add(this.timelabel);
            this.panel1.Controls.Add(this.simplifyButton);
            this.panel1.Controls.Add(this.button1);
            this.panel1.Location = new System.Drawing.Point(12, 12);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(223, 279);
            this.panel1.TabIndex = 0;
            // 
            // epsilonBox
            // 
            this.epsilonBox.DecimalPlaces = 5;
            this.epsilonBox.Increment = new decimal(new int[] {
            1,
            0,
            0,
            131072});
            this.epsilonBox.Location = new System.Drawing.Point(75, 223);
            this.epsilonBox.Name = "epsilonBox";
            this.epsilonBox.Size = new System.Drawing.Size(120, 20);
            this.epsilonBox.TabIndex = 12;
            this.epsilonBox.Value = new decimal(new int[] {
            5,
            0,
            0,
            131072});
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(10, 223);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(44, 13);
            this.label2.TabIndex = 11;
            this.label2.Text = "Epsilon:";
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(77, 184);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 10;
            this.button2.Text = "Save IP";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // ipBox
            // 
            this.ipBox.Location = new System.Drawing.Point(77, 158);
            this.ipBox.Name = "ipBox";
            this.ipBox.Size = new System.Drawing.Size(118, 20);
            this.ipBox.TabIndex = 9;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(7, 161);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(20, 13);
            this.label1.TabIndex = 8;
            this.label1.Text = "IP:";
            // 
            // queryValue
            // 
            this.queryValue.AutoSize = true;
            this.queryValue.Location = new System.Drawing.Point(107, 125);
            this.queryValue.Name = "queryValue";
            this.queryValue.Size = new System.Drawing.Size(13, 13);
            this.queryValue.TabIndex = 7;
            this.queryValue.Text = "--";
            // 
            // queryLabel
            // 
            this.queryLabel.AutoSize = true;
            this.queryLabel.Location = new System.Drawing.Point(4, 125);
            this.queryLabel.Name = "queryLabel";
            this.queryLabel.Size = new System.Drawing.Size(64, 13);
            this.queryLabel.TabIndex = 6;
            this.queryLabel.Text = "Query Time:";
            // 
            // rateValue
            // 
            this.rateValue.AutoSize = true;
            this.rateValue.Location = new System.Drawing.Point(107, 103);
            this.rateValue.Name = "rateValue";
            this.rateValue.Size = new System.Drawing.Size(13, 13);
            this.rateValue.TabIndex = 5;
            this.rateValue.Text = "--";
            // 
            // timeValue
            // 
            this.timeValue.AutoSize = true;
            this.timeValue.Location = new System.Drawing.Point(107, 81);
            this.timeValue.Name = "timeValue";
            this.timeValue.Size = new System.Drawing.Size(13, 13);
            this.timeValue.TabIndex = 4;
            this.timeValue.Text = "--";
            // 
            // rateLabel
            // 
            this.rateLabel.AutoSize = true;
            this.rateLabel.Location = new System.Drawing.Point(4, 103);
            this.rateLabel.Name = "rateLabel";
            this.rateLabel.Size = new System.Drawing.Size(96, 13);
            this.rateLabel.TabIndex = 3;
            this.rateLabel.Text = "Compression Rate:";
            // 
            // timelabel
            // 
            this.timelabel.AutoSize = true;
            this.timelabel.Location = new System.Drawing.Point(4, 81);
            this.timelabel.Name = "timelabel";
            this.timelabel.Size = new System.Drawing.Size(96, 13);
            this.timelabel.TabIndex = 2;
            this.timelabel.Text = "Compression Time:";
            // 
            // simplifyButton
            // 
            this.simplifyButton.Location = new System.Drawing.Point(77, 45);
            this.simplifyButton.Name = "simplifyButton";
            this.simplifyButton.Size = new System.Drawing.Size(75, 23);
            this.simplifyButton.TabIndex = 1;
            this.simplifyButton.Text = "Simplify";
            this.simplifyButton.UseVisualStyleBackColor = true;
            this.simplifyButton.Click += new System.EventHandler(this.simplifyButton_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(77, 16);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Open File";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.rawDataBrowser);
            this.panel2.Location = new System.Drawing.Point(257, 12);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(500, 500);
            this.panel2.TabIndex = 1;
            // 
            // rawDataBrowser
            // 
            this.rawDataBrowser.Dock = System.Windows.Forms.DockStyle.Fill;
            this.rawDataBrowser.Location = new System.Drawing.Point(0, 0);
            this.rawDataBrowser.MinimumSize = new System.Drawing.Size(20, 20);
            this.rawDataBrowser.Name = "rawDataBrowser";
            this.rawDataBrowser.Size = new System.Drawing.Size(500, 500);
            this.rawDataBrowser.TabIndex = 0;
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.resultBrowser);
            this.panel3.Location = new System.Drawing.Point(807, 13);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(500, 500);
            this.panel3.TabIndex = 2;
            // 
            // resultBrowser
            // 
            this.resultBrowser.Dock = System.Windows.Forms.DockStyle.Fill;
            this.resultBrowser.Location = new System.Drawing.Point(0, 0);
            this.resultBrowser.MinimumSize = new System.Drawing.Size(20, 20);
            this.resultBrowser.Name = "resultBrowser";
            this.resultBrowser.Size = new System.Drawing.Size(500, 500);
            this.resultBrowser.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1331, 525);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.epsilonBox)).EndInit();
            this.panel2.ResumeLayout(false);
            this.panel3.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.WebBrowser rawDataBrowser;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Button simplifyButton;
        private System.Windows.Forms.Label rateValue;
        private System.Windows.Forms.Label timeValue;
        private System.Windows.Forms.Label rateLabel;
        private System.Windows.Forms.Label timelabel;
        private System.Windows.Forms.WebBrowser resultBrowser;
        private System.Windows.Forms.Label queryValue;
        private System.Windows.Forms.Label queryLabel;
        private System.Windows.Forms.TextBox ipBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.NumericUpDown epsilonBox;
        private System.Windows.Forms.Label label2;
    }
}

