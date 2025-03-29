import React, { useState, useEffect } from "react";
import { Doughnut, Line, Bar } from "react-chartjs-2";
import { Chart as ChartJS, ArcElement, Tooltip, Legend, CategoryScale, LinearScale, BarElement, PointElement, LineElement } from "chart.js";
import ProgressCircle from "../component/ProgressCircle";
import { useNavigate } from "react-router-dom";
import "../styles/Admin.scss";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft, faCheck, faTimes } from "@fortawesome/free-solid-svg-icons";
import { XIcon, LoaderIcon, Check, Combine } from "lucide-react";
import axios from "axios";

ChartJS.register(ArcElement, Tooltip, Legend, CategoryScale, LinearScale, BarElement, PointElement, LineElement);

function Admin() {
  const [statsSection, setStatsSection] = useState(true);
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [stats, setStats] = useState({ reviewed: 0, rejected: 0, total: 0 });
  const [pendingCount, setPendingCount] = useState(0);
  const [acceptedCount, setAcceptedCount] = useState(0);
  const [rejectedCount, setRejectedCount] = useState(0);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchPosts = async () => {
        setLoading(true);
        try {
            const response = await fetch("http://localhost:5000/api/auth/all-posts-request", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ userID: 1, status: "pending" }),
            });

            const result = await response.json();

            if (!response.ok) {
                throw new Error(result.error || "Erreur inconnue");
            }

            setPosts(result.data);
        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    };

    fetchPosts();
  }, []);

  const updatePostStatus = async (postID, status) => {
    try {
        const response = await fetch("http://localhost:5000/api/auth/update-post-status", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ postID, status }),
        });

        if (!response.ok) {
            throw new Error("Erreur lors de la mise à jour du statut");
        }

        setPosts(posts.map(post => 
            post.postID === postID ? { ...post, status, hideButtons: true } : post
        ));
    } catch (err) {
        console.error("Erreur:", err);
        setError("Impossible de mettre à jour le statut");
    }
};

useEffect(() => {
  Promise.all([
    fetch("http://localhost:5000/api/auth/pending-posts-count").then(res => res.json()),
    fetch("http://localhost:5000/api/auth/accepted-posts-count").then(res => res.json()),
    fetch("http://localhost:5000/api/auth/rejected-posts-count").then(res => res.json()) // Correction ici
  ])
  .then(([pendingData, acceptedData, rejectedData]) => {
    console.log("Données reçues:", pendingData, acceptedData, rejectedData);
    
    setPendingCount(Number(pendingData.pendingCount) || 0);
    setAcceptedCount(Number(acceptedData.acceptedCount) || 0);
    setRejectedCount(Number(rejectedData.rejectedCount) || 0);
    
    setLoading(false);
  })
  .catch(err => {
    console.error("Erreur lors de la récupération des données:", err);
    setError("Impossible de récupérer les données.");
    setLoading(false);
  });
}, []);

useEffect(() => {
  fetch("http://localhost:5000/api/auth/all-posts-Day", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ userID: "123" }) // استبدل بمعرف المستخدم الحقيقي
  })
    .then(res => res.json())
    .then(data => {
      console.log("Data received:", data); // تأكيد استقبال البيانات
      setLineData(prevData => ({
        ...prevData,
        labels: data.labels,
        datasets: [
          {
            ...prevData.datasets[0],
            data: data.data
          }
        ]
      }));
    })
    .catch(error => console.error("Error fetching data:", error));
}, []);

useEffect(() => {
  fetch("http://localhost:5000/api/auth/all-posts-Month", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ userID: "123" }), // Remplace par l'ID utilisateur réel
  })
    .then(res => res.json())
    .then(data => {
      console.log("Data received for monthly stats:", data);

      setBarData({
        labels: data.labels, // Mois
        datasets: [
          {
            label: "Requests per Month",
            data: data.data, // Nombre de posts par mois
            backgroundColor: "#3F51B5",
          },
        ],
      });
    })
    .catch(error => console.error("Error fetching monthly data:", error));
}, []);

  const totalRequests = pendingCount + acceptedCount + rejectedCount;
  const approvedRate = totalRequests > 0 ? (acceptedCount / totalRequests) * 100 : 0;
  const rejectedRate = totalRequests > 0 ? (rejectedCount / totalRequests) * 100 : 0;


  const doughnutData = {
    labels: ["Approved", "Rejected", "Pending"],
    datasets: [
      {
        data: [acceptedCount, rejectedCount, pendingCount],
        backgroundColor: ["#4CAF50", "#F44336", "#FFC107"],
      },
    ],
  };

  const [lineData, setLineData] = useState({
    labels: [],
    datasets: [
      {
        label: "Requests per Day",
        data: [],
        borderColor: "rgba(33, 150, 243, 1)",
        backgroundColor: "rgba(33, 150, 243, 0.2)", 
        borderWidth: 3, 
        pointBackgroundColor: "white", 
        pointBorderColor: "rgba(33, 150, 243, 1)", 
        pointRadius: 6, 
        pointHoverRadius: 8, 
        tension: 0.4, 
        fill: true 
      }
    ]
  });
  
  const options = {
    responsive: true,
    plugins: {
      legend: {
        display: true,
        labels: {
          color: "#333",
          font: {
            size: 14
          }
        }
      }
    },
    scales: {
      x: {
        ticks: {
          color: "#555",
          font: {
            size: 13
          }
        },
        grid: {
          display: false
        }
      },
      y: {
        ticks: {
          color: "#555",
          font: {
            size: 13
          },
          beginAtZero: true
        },
        grid: {
          color: "rgba(200, 200, 200, 0.2)"
        }
      }
    }
  };

  const [barData, setBarData] = useState({
    labels: [],
    datasets: [
      {
        label: "Requests per Month",
        data: [],
        backgroundColor: "#3F51B5",
      },
    ],
  });
  

  return (
    <div className="admin-container">
      <div className="admin-header">
        <p className="admin-header-section" onClick={() => setStatsSection(true)}>Dashboard</p>
        <p className="admin-header-section" onClick={() => setStatsSection(false)}>Requests</p>
      </div>

      {statsSection ? (
        <div className="stats-section-container">
          <div className="request-progress-section">
            <div className="request-section-first">
              <div className="progress-circle">
                <ProgressCircle reviewed={acceptedCount} total={totalRequests} />
                <p>{acceptedCount} requests have been approved</p>
              </div>
              <div className="request-summary">
                <h3>Request Summary</h3><hr className="hrr"/>
                <ul className="summary-list">
                  <li className="summary-item"><Combine /><span>{totalRequests}</span><p>Total</p></li>
                  <li className="summary-item"><Check /><span>{acceptedCount}</span><p>Approved</p></li>
                  <li className="summary-item"><LoaderIcon  /><span>{pendingCount}</span><p>Pending</p></li>
                  <li className="summary-item"><XIcon /><span>{rejectedCount}</span><p>Rejected</p></li>
                </ul>
              </div>
            </div>

            <div className="approval-rate">
              <h3>Approval & Rejection Rate</h3>
              <div className="progress-bar-admin">
                <div className="approved-bar" style={{ width: `${approvedRate}%` }}></div>
                <div className="rejected-bar" style={{ width: `${rejectedRate}%` }}></div>
              </div>
              <p>✅ {Math.round(approvedRate)}% Approved | ❌ {Math.round(rejectedRate)}% Rejected</p>
            </div>
          </div>

          <div className="charts-section">
            <div className="chart-row">
              <div className="chart-container">
                <h3>Requests Distribution</h3>
                <Doughnut data={doughnutData} />
              </div>
              <div className="chart-container">
              <h3 style={{ textAlign: "center", color: "#333", marginBottom: "15px" }}> Requests per Day of the Week </h3>
                <Line data={lineData} options={options} />
              </div>
              <div className="chart-container">
                <h3>Requests per Month</h3>
                <Bar data={barData}  />
              </div>
            </div>
          </div>
        </div>
      ) : (
        <div className="request-section">
          <h3 className="all-posts">All Posts</h3>
          {posts.length > 0 ? (
            posts.map(post => (
              <li key={post.postID} className="post-item" onClick={() => navigate(`/post/${post.postID}`)}>
                <img src={post.pic1} alt="Post" className="post-image"  />
                <div className="post-details">
                  <p><strong> {post.state} </strong></p>
                  <p><strong> {post.price} </strong> </p>
                  <p><strong> {post.Muniplicyt}, {post.street} </strong> </p>
                </div>
                {!post.hideButtons && (
                  <div className="post-actions">
                    <button className="accept-button" onClick={(e) => { e.stopPropagation(); updatePostStatus(post.postID, "Accepted"); }}>
                      <FontAwesomeIcon icon={faCheck} /> Accept
                    </button>
                    <button className="reject-button" onClick={(e) => { e.stopPropagation(); updatePostStatus(post.postID, "Rejected"); }}>
                      <FontAwesomeIcon icon={faTimes} /> Reject
                    </button>
                  </div>
                )}
              </li>
            ))
          ) : (
            <p className="no-posts"> No posts found.</p>
          )}
        </div>
      )}
    </div>
  );
}

export default Admin;